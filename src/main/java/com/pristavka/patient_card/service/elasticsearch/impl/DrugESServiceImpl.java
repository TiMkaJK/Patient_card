package com.pristavka.patient_card.service.elasticsearch.impl;

import com.pristavka.patient_card.model.elasticsearch.DrugES;
import com.pristavka.patient_card.model.mongo.Drug;
import com.pristavka.patient_card.repository.mongo.DrugMongoDBRepository;
import com.pristavka.patient_card.service.elasticsearch.DrugESService;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.common.geo.GeoDistance;
import org.elasticsearch.common.unit.DistanceUnit;
import org.elasticsearch.index.query.*;
import org.elasticsearch.search.aggregations.AbstractAggregationBuilder;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.metrics.ValueCountAggregationBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class DrugESServiceImpl implements DrugESService {

    @Autowired
    private DrugMongoDBRepository drugMongoDBRepository;

    @Autowired
    private ElasticsearchRestTemplate elasticsearchRestTemplate;

    @Override
    public List<Drug> findDrugByName(String name) {

        MatchQueryBuilder queryBuilder = QueryBuilders.matchQuery("name", name);

        Query matchQuery = new NativeSearchQueryBuilder()
                .withQuery(queryBuilder)
                .build();

        SearchHits<DrugES> drugESSearchHits = this.elasticsearchRestTemplate.search(matchQuery, DrugES.class, IndexCoordinates.of("drugs_index"));

        return getDrugs(drugESSearchHits);
    }

    @Override
    public List<Drug> findDrugsGreaterThan(LocalDate dateFrom, LocalDate dateTo) {

        RangeQueryBuilder queryBuilder = QueryBuilders.rangeQuery("manufacture_date")
                .gte(dateFrom)
                .lte(dateTo);

        Query rangeQuery = new NativeSearchQueryBuilder()
                .withQuery(queryBuilder)
                .build();

        return getDrugs(this.elasticsearchRestTemplate.search(rangeQuery, DrugES.class, IndexCoordinates.of("drugs_index")));
    }

    @Override
    public List<Drug> findDrugGeoLocation(String latitude, String longitude, Integer distance) {

        GeoDistanceQueryBuilder queryBuilder = QueryBuilders.geoDistanceQuery("coordinates")
                .point(Double.parseDouble(latitude), Double.parseDouble(longitude))
                .distance(distance, DistanceUnit.KILOMETERS)
                .geoDistance(GeoDistance.PLANE);

        BoolQueryBuilder bq = QueryBuilders.boolQuery()
                .must(QueryBuilders.matchAllQuery())
                .filter(queryBuilder);

        Query geoDistanceQuery = new NativeSearchQueryBuilder()
                .withQuery(bq)
                .build();

        return getDrugs(this.elasticsearchRestTemplate.search(geoDistanceQuery, DrugES.class, IndexCoordinates.of("drugs_index")));
    }

    @Override
    public List<Drug> getDrugsCountByManufactureIndex(String index) {

        MatchQueryBuilder queryBuilder = QueryBuilders.matchQuery("manufacturer.index", index);

        AbstractAggregationBuilder<ValueCountAggregationBuilder> ag = AggregationBuilders.count("id");

        Query matchQuery = new NativeSearchQueryBuilder()
                .withQuery(queryBuilder)
                .addAggregation(ag)
                .build();

        SearchHits<DrugES> drugESSearchHits = this.elasticsearchRestTemplate.search(matchQuery, DrugES.class, IndexCoordinates.of("drugs_index"));

        return getDrugs(drugESSearchHits);
    }

    @Override
    public List<Drug> findDrugsByNameWithMistakes(String name) {

        FuzzyQueryBuilder queryBuilder = QueryBuilders.fuzzyQuery("name", name);

        Query fuzzyQuery = new NativeSearchQueryBuilder()
                .withQuery(queryBuilder)
                .build();

        return getDrugs(this.elasticsearchRestTemplate.search(fuzzyQuery, DrugES.class, IndexCoordinates.of("drugs_index")));
    }

    @Override
    public List<Drug> findDrugsByPrefix(String prefix) {
        PrefixQueryBuilder queryBuilder = QueryBuilders.prefixQuery("name", prefix)
                .caseInsensitive(true);

        Query prefixQuery = new NativeSearchQueryBuilder()
                .withQuery(queryBuilder)
                .build();

        return getDrugs(this.elasticsearchRestTemplate.search(prefixQuery, DrugES.class, IndexCoordinates.of("drugs_index")));
    }

    @Override
    public List<Drug> test(String name, String contraindications) {

        BoolQueryBuilder queryBuilder = QueryBuilders.boolQuery()
                .must(QueryBuilders.termQuery("name", name))
                .must(QueryBuilders.matchQuery("contraindications", contraindications));

        Query matchQuery = new NativeSearchQueryBuilder()
                .withQuery(queryBuilder)
                .build();

        SearchHits<DrugES> drugESSearchHits = this.elasticsearchRestTemplate.search(matchQuery, DrugES.class, IndexCoordinates.of("drugs_index"));

        return getDrugs(drugESSearchHits);
    }

    private List<Drug> getDrugs(SearchHits<DrugES> drugSearchHits) {

        List<String> ids = drugSearchHits.get()
                .map(h -> h.getContent().getId())
                .collect(Collectors.toList());

        return this.drugMongoDBRepository.findDrugsByIdIn(ids);
    }

}


package com.pristavka.patient_card.service.elasticsearch.impl;

import com.pristavka.patient_card.model.elasticsearch.DrugES;
import com.pristavka.patient_card.model.mongo.Drug;
import com.pristavka.patient_card.repository.mongo.DrugMongoDBRepository;
import com.pristavka.patient_card.service.elasticsearch.DrugESService;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.common.geo.GeoDistance;
import org.elasticsearch.common.unit.DistanceUnit;
import org.elasticsearch.index.query.*;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
import org.elasticsearch.search.sort.FieldSortBuilder;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Slf4j
@Service
public class DrugESServiceImpl implements DrugESService {

    @Autowired
    private DrugMongoDBRepository drugMongoDBRepository;

    @Autowired
    private ElasticsearchRestTemplate elasticsearchRestTemplate;

    private IndexCoordinates indexCoordinates;

    @PostConstruct
    public void init() {
        this.indexCoordinates = this.elasticsearchRestTemplate.getIndexCoordinatesFor(DrugES.class);
    }

    @Override
    public List<Drug> findDrugByName(String name) {

        MatchQueryBuilder queryBuilder = QueryBuilders.matchQuery("name", name);

        Query matchQuery = new NativeSearchQueryBuilder()
                .withQuery(queryBuilder)
                .build();

        SearchHits<DrugES> drugESSearchHits = this.elasticsearchRestTemplate.search(matchQuery, DrugES.class, this.indexCoordinates);

        return getSortedData(drugESSearchHits);
    }

    @Override
    public List<Drug> findDrugsGreaterThan(LocalDate dateFrom, LocalDate dateTo) {

        RangeQueryBuilder queryBuilder = QueryBuilders.rangeQuery("manufacture_date")
                .gte(dateFrom)
                .lte(dateTo);

        Query rangeQuery = new NativeSearchQueryBuilder()
                .withQuery(queryBuilder)
                .build();

        return getSortedData(this.elasticsearchRestTemplate.search(rangeQuery, DrugES.class, this.indexCoordinates));
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

        return getSortedData(this.elasticsearchRestTemplate.search(geoDistanceQuery, DrugES.class, this.indexCoordinates));
    }

    @Override
    public List<Drug> getDrugsWithGroupingBy() {

        MatchAllQueryBuilder queryBuilder = QueryBuilders.matchAllQuery();

        TermsAggregationBuilder ag = AggregationBuilders.terms("manufacturerNames").field("manufacturer.name");

        FieldSortBuilder sb = SortBuilders.fieldSort("manufacturer.name").order(SortOrder.ASC);

        Query matchQuery = new NativeSearchQueryBuilder()
                .withQuery(queryBuilder)
                .withSort(sb)
                .addAggregation(ag)
                .build();

        SearchHits<DrugES> drugESSearchHits = this.elasticsearchRestTemplate.search(matchQuery, DrugES.class, this.indexCoordinates);

        return getSortedData(drugESSearchHits);
    }

    @Override
    public List<Drug> findDrugsByNameWithMistakes(String name) {

        FuzzyQueryBuilder queryBuilder = QueryBuilders.fuzzyQuery("name", name);

        Query fuzzyQuery = new NativeSearchQueryBuilder()
                .withQuery(queryBuilder)
                .build();

        return getSortedData(this.elasticsearchRestTemplate.search(fuzzyQuery, DrugES.class, this.indexCoordinates));
    }

    @Override
    public List<Drug> findDrugsByPrefix(String prefix, Pageable pageable) {

        PrefixQueryBuilder queryBuilder = QueryBuilders.prefixQuery("contraindications", prefix)
                .caseInsensitive(true);

        Query prefixQuery = new NativeSearchQueryBuilder()
                .withQuery(queryBuilder)
                .withPageable(pageable)
                .build();

        return getSortedData(this.elasticsearchRestTemplate.search(prefixQuery, DrugES.class, this.indexCoordinates));
    }

    @Override
    public List<Drug> findDrugsByNameAndContraindications(String name, String contraindications) {

        BoolQueryBuilder queryBuilder = QueryBuilders.boolQuery()
                .must(QueryBuilders.termQuery("name", name))
                .must(QueryBuilders.matchQuery("contraindications", contraindications));

        Query matchQuery = new NativeSearchQueryBuilder()
                .withQuery(queryBuilder)
                .build();

        SearchHits<DrugES> drugESSearchHits = this.elasticsearchRestTemplate.search(matchQuery, DrugES.class, this.indexCoordinates);

        return getSortedData(drugESSearchHits);
    }

    @Override
    public List<Drug> findDrugsWithWildcard(String begin, String end) {

        WildcardQueryBuilder queryBuilder = QueryBuilders.wildcardQuery("name", begin + "*")
                .caseInsensitive(true);

        Query matchQuery = new NativeSearchQueryBuilder()
                .withQuery(queryBuilder)
                .build();

        SearchHits<DrugES> drugESSearchHits = this.elasticsearchRestTemplate.search(matchQuery, DrugES.class, this.indexCoordinates);

        return getSortedData(drugESSearchHits);
    }

    @Override
    public List<Drug> getDrugsWithAggregations() {

        MatchAllQueryBuilder queryBuilder = QueryBuilders.matchAllQuery();

        TermsAggregationBuilder manufacturerNamesAggregation = AggregationBuilders.terms("manufacturerNames")
                .field("manufacturer.name");
        TermsAggregationBuilder manufacturerCitiesAggregation = AggregationBuilders.terms("manufacturerCities")
                .field("manufacturer.city");

        Query matchQuery = new NativeSearchQueryBuilder()
                .withQuery(queryBuilder)
                .addAggregation(manufacturerNamesAggregation)
                .addAggregation(manufacturerCitiesAggregation)
                .build();

        SearchHits<DrugES> drugESSearchHits = this.elasticsearchRestTemplate.search(matchQuery, DrugES.class, this.indexCoordinates);

        return getSortedData(drugESSearchHits);
    }

    private List<Drug> getData(SearchHits<DrugES> drugSearchHits) {

        List<String> ids = drugSearchHits.get()
                .map(h -> h.getContent().getId())
                .collect(Collectors.toList());

        return this.drugMongoDBRepository.findDrugsByIdIn(ids);
    }

    private List<Drug> getSortedData(SearchHits<DrugES> drugSearchHits) {

        Map<String, Drug> drugsMap = this.drugMongoDBRepository.findAllBy()
                .collect(Collectors.toMap(Drug::getId, Function.identity()));

        return drugSearchHits.getSearchHits()
                .stream()
                .map(d -> drugsMap.getOrDefault(d.getContent().getId(), null))
                .collect(Collectors.toList());
    }
}


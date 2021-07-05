package com.pristavka.patient_card.model.elasticsearch;

import lombok.*;
import org.elasticsearch.common.geo.GeoPoint;
import org.springframework.data.elasticsearch.annotations.*;

import javax.persistence.Id;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Document(indexName = "drugs_index")
public class DrugES {

    @Id
    private String id;

    /*@MultiField(
            mainField = @Field(name = "name", type = FieldType.Text),
            otherFields = {
                    @InnerField(type = FieldType.Keyword, suffix = "keyword")
            }
    )*/
//    @Field(name = "name", type = FieldType.Keyword)
    @Field(name = "name", type = FieldType.Text)
    private String name;

    @Field(name = "manufacture_date", type = FieldType.Date, format = DateFormat.date)
    private LocalDate manufactureDate;

    @Field(name = "manufacturer", type = FieldType.Object)
    private ManufacturerES manufacturer;

    @GeoPointField
    private GeoPoint coordinates;

    @Field(type = FieldType.Text)
    private Set<String> contraindications = new HashSet<>();
}



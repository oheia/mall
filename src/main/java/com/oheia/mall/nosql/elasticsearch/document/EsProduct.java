package com.oheia.mall.nosql.elasticsearch.document;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * 不需要中文分词的字段设置成@Field(type = FieldType.Keyword)类型，
 * 需要中文分词的设置成@Field(analyzer = "ik_max_word",type = FieldType.Text)类型。
 */
@Data
@ToString
@Document(indexName = "pms", type = "product",shards = 1,replicas = 0)
public class EsProduct implements Serializable {
    private static final long serialVersionUID = -1L;

    @Id
    private Long id;

    @Field(type = FieldType.Keyword)
    private String productSn;

    private Long brandId;

    @Field(type = FieldType.Keyword)
    private String brandName;

    private Long productCategoryId;

    @Field(type = FieldType.Keyword)
    private String productCategoryName;

    private String pic;

    @Field(analyzer = "ik_max_word", type = FieldType.Text)
    private String name;

    @Field(analyzer = "ik_max_word", type = FieldType.Text)
    private String subTitle;

    @Field(analyzer = "ik_max_word", type = FieldType.Text)
    private String keywords;

    private BigDecimal price;

    private Integer sale;

    private Integer newStatus;

    private Integer recommendStatus;

    private Integer stock;

    private Integer promotionType;

    private Integer sort;

    @Field(type = FieldType.Nested)
    private List<EsProductAttributeValue> attrValueList;
}

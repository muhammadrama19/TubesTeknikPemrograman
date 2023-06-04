package com.programming.techue.springbootmongodbtutorial.model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.index.Indexed;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document("ara")
public class Kopi {
    @Id
    private String id;
    @Field("name")
    @Indexed(unique = true)
    private String kopiName;
    @Field("category")
    private KopiCategory kopiCategory;
    @Field("amount")
    private BigDecimal kopiAmount;
}

/*
    Copyright (C) 2015  Jean-Loup Adde

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/


package integrationTest.domain;

import fr.juanwolf.mysqlbinlogreplicator.annotations.MysqlMapping;
import fr.juanwolf.mysqlbinlogreplicator.annotations.NestedMapping;
import fr.juanwolf.mysqlbinlogreplicator.nested.SQLRelationship;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.*;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * Created by juanwolf on 17/07/15.
 */
@Document(indexName = "user")
@Mapping(mappingPath = "user")
@MysqlMapping(table = "user", repository="userRepository")
public class User {
    @Id
    @Setter
    @Getter
    Integer id;

    @Getter
    @Field(type = FieldType.Integer, index = FieldIndex.analyzed)
    Integer identifier;

    @Getter
    @Setter
    @Field(type = FieldType.String, index = FieldIndex.analyzed)
    String mail;

    @Getter
    @Field(index = FieldIndex.analyzed, type = FieldType.Date)
    Date creationDate;

    @Getter
    @Field(index = FieldIndex.analyzed, type = FieldType.Float)
    float cartAmount;

//    @Getter
//    @Setter
//    @Field(index = FieldIndex.analyzed, type = FieldType.Boolean)
//    boolean isAdmin;


    @Getter
    @NestedMapping(table = "cart", foreignKey="cart_id", sqlAssociaton=SQLRelationship.MANY_TO_ONE)
    Cart     cart;

}

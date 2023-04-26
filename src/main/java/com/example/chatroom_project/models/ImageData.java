package com.example.chatroom_project.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ImageData")
@Data
@AllArgsConstructor
@NoArgsConstructor
// Since we are using the Lombok maven dependency we can use the @Data, @AllArgsConstructor and @NoArgsConstructor because it will automatically generate our getters and setters (the POJO stuff)

@Builder // from lombok and it allows us to construct complex objects without having a common interface. it creates an inner static builder class. (side note: there is a @SuperBuilder which does the same but also works with superclasses).
public class ImageData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String type;
    @Lob  // using the l.o.b annotation because it will convert our binary format name and type properties into the byte format we need for imageData.
    @Column(name = "imagedata")
    private byte[] imageData;

// consider adding column length restrictions so: "@Column(name = "imagedata", length = 1000)

}

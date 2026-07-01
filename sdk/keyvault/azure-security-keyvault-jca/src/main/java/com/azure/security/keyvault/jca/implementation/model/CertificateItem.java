// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.security.keyvault.jca.implementation.model;

import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;

import java.io.IOException;

/**
 * The CertificateItem REST model.
 */
public class CertificateItem implements JsonSerializable<CertificateItem> {
    /**
     * Stores the id.
     */
    private String id;

    /**
     * Stores the attributes.
     */
    private CertificateItemAttributes attributes;

    /**
     * Get the id.
     *
     * @return the id.
     */
    public String getId() {
        return id;
    }

    /**
     * Set the id.
     *
     * @param id the id.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Get the attributes.
     *
     * @return the attributes.
     */
    public CertificateItemAttributes getAttributes() {
        return attributes;
    }

    /**
     * Set the attributes.
     *
     * @param attributes the attributes.
     */
    public void setAttributes(CertificateItemAttributes attributes) {
        this.attributes = attributes;
    }

    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("id", this.id);
        jsonWriter.writeJsonField("attributes", this.attributes);

        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of {@link CertificateItem} from the {@link JsonReader}.
     *
     * @param jsonReader The {@link JsonReader} being read.
     *
     * @return An instance of {@link CertificateItem} if the {@link JsonReader} was pointing to an instance of it, or
     * {@code null} if it was pointing to JSON {@code null}.
     *
     * @throws IOException If an error occurs while reading the {@link CertificateItem}.
     */
    public static CertificateItem fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            CertificateItem deserializedCertificateItem = new CertificateItem();

            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();

                reader.nextToken();

                if ("id".equals(fieldName)) {
                    deserializedCertificateItem.id = reader.getString();
                } else if ("attributes".equals(fieldName)) {
                    deserializedCertificateItem.attributes = CertificateItemAttributes.fromJson(reader);
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedCertificateItem;
        });
    }
}

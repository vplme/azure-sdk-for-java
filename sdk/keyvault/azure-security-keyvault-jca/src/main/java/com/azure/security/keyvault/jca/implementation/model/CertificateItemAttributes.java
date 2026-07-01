// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.security.keyvault.jca.implementation.model;

import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;

import java.io.IOException;

/**
 * The CertificateItemAttributes REST model.
 */
public class CertificateItemAttributes implements JsonSerializable<CertificateItemAttributes> {
    /**
     * Stores the enabled flag.
     */
    private Boolean enabled;

    /**
     * Get the enabled flag.
     *
     * @return the enabled flag.
     */
    public Boolean getEnabled() {
        return enabled;
    }

    /**
     * Set the enabled flag.
     *
     * @param enabled the enabled flag.
     */
    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeBooleanField("enabled", this.enabled);

        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of {@link CertificateItemAttributes} from the {@link JsonReader}.
     *
     * @param jsonReader The {@link JsonReader} being read.
     *
     * @return An instance of {@link CertificateItemAttributes} if the {@link JsonReader} was pointing to an instance
     * of it, or {@code null} if it was pointing to JSON {@code null}.
     *
     * @throws IOException If an error occurs while reading the {@link CertificateItemAttributes}.
     */
    public static CertificateItemAttributes fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            CertificateItemAttributes deserializedCertificateItemAttributes = new CertificateItemAttributes();

            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();

                reader.nextToken();

                if ("enabled".equals(fieldName)) {
                    deserializedCertificateItemAttributes.enabled = reader.getNullable(JsonReader::getBoolean);
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedCertificateItemAttributes;
        });
    }
}

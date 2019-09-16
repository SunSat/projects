package com.sunsat.sathish.java.orchestrator.validation;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.SimpleType;
import com.fasterxml.jackson.module.jsonSchema.JsonSchema;
import com.fasterxml.jackson.module.jsonSchema.JsonSchemaGenerator;

public class SchemaGenerator {
    public static void main(String[] args) {

        ObjectMapper mapper = new ObjectMapper();

        JsonSchemaGenerator jsonSchemaGenerator = new JsonSchemaGenerator(mapper);
        try {
            com.fasterxml.jackson.databind.jsonschema.JsonSchema schema1 = mapper.generateJsonSchema(Student.class);
            System.out.println(schema1);

            JsonSchema schema = jsonSchemaGenerator.generateSchema(MyClass.class);
            //System.out.println( mapper.generateJsonSchema(Student.class));
            System.out.println(schema.get$schema());
        } catch (JsonMappingException e) {
            e.printStackTrace();
        }
    }
}

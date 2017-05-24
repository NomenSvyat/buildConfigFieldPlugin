package com.github.nomensvyat.switchbox;

import com.android.build.gradle.internal.dsl.BuildType;
import com.android.build.gradle.internal.dsl.ProductFlavor;
import com.android.builder.model.ClassField;
import com.github.nomensvyat.switchbox.fields.Field;

import java.util.Map;

class FieldContainerFabric {

    public static FieldContainer create(final ProductFlavor productFlavor) {
        return new FieldContainer() {
            @Override
            public void add(Field field) {
                productFlavor.buildConfigField(field.getType(), field.getName(), field.getValue());
            }

            @Override
            public void remove(Field field) {
                Map<String, ClassField> buildConfigFields = productFlavor.getBuildConfigFields();
                if (buildConfigFields != null) {
                    buildConfigFields.remove(field.getName());
                }
            }

            @Override
            public String getName() {
                return productFlavor.getName();
            }
        };
    }

    public static FieldContainer createDefault(ProductFlavor productFlavor) {
        return new FieldContainer() {
            @Override
            public void add(Field field) {
                productFlavor.buildConfigField(field.getType(), field.getName(), field.getValue());
            }

            @Override
            public void remove(Field field) {
                Map<String, ClassField> buildConfigFields = productFlavor.getBuildConfigFields();
                if (buildConfigFields != null) {
                    buildConfigFields.remove(field.getName());
                }
            }

            @Override
            public String getName() {
                return "default";
            }
        };
    }

    public static FieldContainer create(final BuildType buildType) {
        return new FieldContainer() {
            @Override
            public void add(Field field) {
                buildType.buildConfigField(field.getType(), field.getName(), field.getValue());
            }

            @Override
            public void remove(Field field) {
                Map<String, ClassField> buildConfigFields = buildType.getBuildConfigFields();
                if (buildConfigFields != null) {
                    buildConfigFields.remove(field.getName());
                }
            }

            @Override
            public String getName() {
                return buildType.getName();
            }
        };
    }
}

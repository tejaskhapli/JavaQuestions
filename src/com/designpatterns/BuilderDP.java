package com.designpatterns;

public class BuilderDP {

}


class Student {

    // final instance fields
    private final int id;
    private final String name;
    private final String address;

    public Student(Builder builder)
    {
        this.id = builder.id;
        this.name = builder.name;
        this.address = builder.address;
    }
    
    // Static class Builder
    public static class Builder {

        // instance fields
        private int id;
        private String name;
        private String address;

        public static Builder newInstance() {
            return new Builder();
        }

        private Builder() {}

        // Setter methods
        public Builder id(int id) {
            this.id = id;
            return this;
        }
        
        public Builder name(String name) {
            this.name = name;
            return this;
        }
        
        public Builder address(String address) {
            this.address = address;
            return this;
        }

        // build method to deal with outer class
        // to return outer instance
        public Student build()
        {
            return new Student(this);
        }
    }


}
package com.company;

public enum Position {
    INTERN("stażysta"),
    JUNIOR_DEVELOPER("młodszy deweloper"),
    DEVELOPER("deweloper"),
    SENIOR_DEVELOPER("starszy deweloper"),
    SCRUM_MASTER("scrum master"),
    PRODUCT_OWNER("product owner"),
    SECOND_MANAGER("drugi menadżer"),
    MANAGER("menadżer");

    private String message;
    private Position(String message){
        this.message=message;
    }
    public String toString(){
        return message;
    }


}

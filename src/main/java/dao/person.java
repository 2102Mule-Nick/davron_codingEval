package dao;

import java.awt.List;
import java.util.ArrayList;
import dao.Relation;

class Person {
    private String name;
    //private Gender gender;
    private List<Relation> relations = new ArrayList<>();

    Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Relation> getRelations() {
        return relations;
    }

    public void setRelations(List<Relation> relations) {
        this.relations = relations;
    }

  ]
    public void addRelation(Relation relation) {
        relations.add(relation);
    }
}
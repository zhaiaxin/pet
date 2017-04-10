package com.pandawork.common.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Pet实体
 *
 * @author zhaiaxin
 * @time: 2017/4/9 15:53.
 */
@Table(name = "t_pet")
@Entity
public class Pet {

    @Id
    private Integer id;

    //大类Id
    @Column(name = "classification_id")
    private Integer classificationId;

    //小类Id
    @Column(name = "classification_p_id")
    private Integer classificationPId;

    //名字
    private String name;

    //摘要
    private String abstracts;

    //形态特征摘要
    @Column(name = "shape_abstract")
    private String shapeAbstract;

    //眼睛描述
    private String eye;

    //耳朵描述
    private String ear;

    //尾巴描述
    private String tail;

    //毛发描述
    private String hair;

    //鼻子描述
    private String nose;

    //与人相处
    @Column(name = "with_people")
    private String withPeople;

    //性格喜好
    private String character;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getClassificationId() {
        return classificationId;
    }

    public void setClassificationId(Integer classificationId) {
        this.classificationId = classificationId;
    }

    public Integer getClassificationPId() {
        return classificationPId;
    }

    public void setClassificationPId(Integer classificationPId) {
        this.classificationPId = classificationPId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbstracts() {
        return abstracts;
    }

    public void setAbstracts(String abstracts) {
        this.abstracts = abstracts;
    }

    public String getShapeAbstract() {
        return shapeAbstract;
    }

    public void setShapeAbstract(String shapeAbstract) {
        this.shapeAbstract = shapeAbstract;
    }

    public String getEye() {
        return eye;
    }

    public void setEye(String eye) {
        this.eye = eye;
    }

    public String getEar() {
        return ear;
    }

    public void setEar(String ear) {
        this.ear = ear;
    }

    public String getTail() {
        return tail;
    }

    public void setTail(String tail) {
        this.tail = tail;
    }

    public String getHair() {
        return hair;
    }

    public void setHair(String hair) {
        this.hair = hair;
    }

    public String getNose() {
        return nose;
    }

    public void setNose(String nose) {
        this.nose = nose;
    }

    public String getWithPeople() {
        return withPeople;
    }

    public void setWithPeople(String withPeople) {
        this.withPeople = withPeople;
    }

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "id=" + id +
                ", classificationId=" + classificationId +
                ", classificationPId=" + classificationPId +
                ", name='" + name + '\'' +
                ", abstracts='" + abstracts + '\'' +
                ", shapeAbstract='" + shapeAbstract + '\'' +
                ", eye='" + eye + '\'' +
                ", ear='" + ear + '\'' +
                ", tail='" + tail + '\'' +
                ", hair='" + hair + '\'' +
                ", nose='" + nose + '\'' +
                ", withPeople='" + withPeople + '\'' +
                ", character='" + character + '\'' +
                '}';
    }
}

package chen.cn.entity;

import java.util.Date;

public class Jc {
    private Integer id;

    private String name;

    private String isbn;

    private String author;

    private Integer publisherId;

    private Double price;

    private Date pubdate;

    private Integer categoryId;

    private String majorText;

    private Integer classseId;

    private String classseText;

    private Integer levelsId;

    private Integer courseId;

    private String courseName;

    private Integer teacherUse;

    private Integer yesorno;

    private String sdDatetime;

    private Integer sdTeacher;

    private Date createTime;

    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn == null ? null : isbn.trim();
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    public Integer getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(Integer publisherId) {
        this.publisherId = publisherId;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Date getPubdate() {
        return pubdate;
    }

    public void setPubdate(Date pubdate) {
        this.pubdate = pubdate;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getMajorText() {
        return majorText;
    }

    public void setMajorText(String majorText) {
        this.majorText = majorText == null ? null : majorText.trim();
    }

    public Integer getClassseId() {
        return classseId;
    }

    public void setClassseId(Integer classseId) {
        this.classseId = classseId;
    }

    public String getClassseText() {
        return classseText;
    }

    public void setClassseText(String classseText) {
        this.classseText = classseText == null ? null : classseText.trim();
    }

    public Integer getLevelsId() {
        return levelsId;
    }

    public void setLevelsId(Integer levelsId) {
        this.levelsId = levelsId;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName == null ? null : courseName.trim();
    }

    public Integer getTeacherUse() {
        return teacherUse;
    }

    public void setTeacherUse(Integer teacherUse) {
        this.teacherUse = teacherUse;
    }

    public Integer getYesorno() {
        return yesorno;
    }

    public void setYesorno(Integer yesorno) {
        this.yesorno = yesorno;
    }

    public String getSdDatetime() {
        return sdDatetime;
    }

    public void setSdDatetime(String sdDatetime) {
        this.sdDatetime = sdDatetime == null ? null : sdDatetime.trim();
    }

    public Integer getSdTeacher() {
        return sdTeacher;
    }

    public void setSdTeacher(Integer sdTeacher) {
        this.sdTeacher = sdTeacher;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
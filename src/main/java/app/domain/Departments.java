package app.domain;

public class Departments {
//    TODO id автоматически добавляет бд, мы ее не заполняем
//    private long id;
    private String nameDepartment;


    public Departments(/*long id,*/ String nameDepartment) {
//        this.id = id;
        this.nameDepartment = nameDepartment;
    }

/*    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
*/
    public String getNamDepartment() {
        return nameDepartment;
    }

    public void setNameDepartment(String nameDepartment) {
        this.nameDepartment = nameDepartment;
    }


}

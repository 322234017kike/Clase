package mx.unam.fes.acatlan.mac.poo.backend;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class AplicacionCursos {
    private ArrayList<Alumno> alumnos;
    private ArrayList<Profesor> profesores;
    private ArrayList<Curso> cursos;
    private Integer posicionAlumnoActual;

    public AplicacionCursos(ArrayList<Alumno> alumnos, ArrayList<Profesor> profesores, ArrayList<Curso> cursos,Integer posicionAlumnoActual) {
        this.alumnos=alumnos;
        this.profesores=profesores;
        this.cursos=cursos;
        this.posicionAlumnoActual=posicionAlumnoActual;
    }

    public AplicacionCursos(){
        //llenado de cursos
        cursos=new ArrayList<Curso>();

        Curso cursoTmp=new Curso(101, 100, "Programación 1");
        cursos.add(cursoTmp);

        cursoTmp=new Curso(102, 90, "Diseño 1");
        cursos.add(cursoTmp);

        cursoTmp=new Curso(103, 80, "Programación 2");
        cursos.add(cursoTmp);

        cursoTmp=new Curso(104, 50, "Redes");
        cursos.add(cursoTmp);

        cursoTmp=new Curso(105, 95, "Diseño Base de datos");
        cursos.add(cursoTmp);

        //llenado de profesores
        profesores=new ArrayList<Profesor>();
        Profesor profTmp=new Profesor("55623", 12345, "Claudia", "Lopez", "Lopez", Genero.FEMENINO, darFecha(24,5,2000));
        profesores.add(profTmp);

        profTmp=new Profesor("256893", 7412, "Sandra", "Sánchez", "Martínez", Genero.FEMENINO, darFecha(14,4,2005));
        profesores.add(profTmp);

        profTmp=new Profesor("89756", 54328, "Ernesto", "Flores", "Cardenas", Genero.MASCULINO, darFecha(8,8,1997));
        profesores.add(profTmp);

        profTmp=new Profesor("8526", 9512, "Monica", "Rivas", "Duarte", Genero.FEMENINO, darFecha(2,5,1995));
        profesores.add(profTmp);

        profTmp=new Profesor("1596", 7536, "Javier", "Lima", "Rojas", Genero.MASCULINO, darFecha(13,5,1996));
        profesores.add(profTmp);

        //llenado de alumnos
        alumnos=new ArrayList<Alumno>();

        Alumno alumnoTmp=new Alumno("foto01.png", "101010", "9", "Karla", "Romero", "Cruz", Genero.FEMENINO, darFecha(15,3,2003));
        alumnos.add(alumnoTmp);

        alumnoTmp=new Alumno("foto02.png", "101010", "9", "Ignacio", "Luna", "Rojas", Genero.MASCULINO, darFecha(22,7,2002));
        alumnos.add(alumnoTmp);

        alumnoTmp=new Alumno("foto03.png", "101011", "8", "Mariana", "Torres", "Vega", Genero.FEMENINO, darFecha(9,11,2003));
        alumnos.add(alumnoTmp);

        alumnoTmp=new Alumno("foto04.png", "101012", "7", "Diego", "Herrera", "Soto", Genero.MASCULINO, darFecha(30,1,2002));
        alumnos.add(alumnoTmp);

        alumnoTmp=new Alumno("foto05.png", "101013", "10", "Valeria", "Ortiz", "Ramos", Genero.FEMENINO, darFecha(18,6,2003));
        alumnos.add(alumnoTmp);

        alumnoTmp=new Alumno("foto06.png", "101014", "8", "Andres", "Castillo", "Mena", Genero.MASCULINO, darFecha(5,9,2001));
        alumnos.add(alumnoTmp);

        alumnoTmp=new Alumno("foto07.png", "101015", "9", "Sofia", "Guzman", "Pineda", Genero.FEMENINO, darFecha(27,12,2002));
        alumnos.add(alumnoTmp);

        alumnoTmp=new Alumno("foto08.png", "101016", "6", "Emilio", "Vargas", "Nava", Genero.MASCULINO, darFecha(12,4,2003));
        alumnos.add(alumnoTmp);

        //establece la posicion actual
        posicionAlumnoActual=0;
    }

    /**
     * Regresa el objeto Date con la fecha del dia, mes y año recibidos
     */
    public Date darFecha(int dia, int mes, int anio) {
        Calendar calendario=Calendar.getInstance();
        calendario.clear();
        calendario.set(anio, mes-1, dia);
        return calendario.getTime();
    }

    public Alumno getAlumnoAnterior() {
        //si la posicion actual es 0 se muestra el ultimo elemento de la lista
        if(posicionAlumnoActual==0) {
            posicionAlumnoActual=alumnos.size()-1;
        }else {
            //en caso contrario se muestra el elemento de la posicion actual-1
            posicionAlumnoActual--;
        }
        return getAlumnoActual();
    }

    public Alumno getAlumnoSiguiente() {
        //si la posicion actual es la ultima de la lista se muestra el primer elemento
        if(posicionAlumnoActual==alumnos.size()-1) {
            posicionAlumnoActual=0;
        }else {
            //en caso contrario se muestra el elemento de la posicion actual+1
            posicionAlumnoActual++;
        }
        return getAlumnoActual();
    }

    public Alumno getAlumnoActual() {
        //con la posición actual recupera de la lista de alumnos al Alumno Actual
        return alumnos.get(posicionAlumnoActual);
    }

    public ArrayList<Alumno> getAlumnos() {
        return alumnos;
    }
    public void setAlumnos(ArrayList<Alumno> alumnos) {
        this.alumnos = alumnos;
    }
    public ArrayList<Profesor> getProfesores() {
        return profesores;
    }
    public void setProfesores(ArrayList<Profesor> profesores) {
        this.profesores = profesores;
    }
    public ArrayList<Curso> getCursos() {
        return cursos;
    }
    public void setCursos(ArrayList<Curso> cursos) {
        this.cursos = cursos;
    }
    public Integer getPosicionAlumnoActual() {
        return posicionAlumnoActual;
    }
    public void setPosicionAlumnoActual(Integer posicionAlumnoActual) {
        this.posicionAlumnoActual = posicionAlumnoActual;
    }
}

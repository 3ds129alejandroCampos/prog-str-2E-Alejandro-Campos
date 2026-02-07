import java.util.Scanner;
void main() {
    Scanner sc=new Scanner(System.in);
    String name;
    double[] calificaciones = new double[3];
    int asistencia;
    boolean proyectoEntregado;

    Input validar=new Input();
    GradeService guardar=new GradeService();
    GradeService.alumnos nuevoAlumno= guardar.new alumnos();





    name=validar.obtenerNombre(sc,"Dame el nombre del alumno");
    for(int i=0;i<3;i++){
        calificaciones[i]=validar.obtenerCalificaciones(sc,"Dame la calificacion");
    }

    asistencia=validar.obtenerAsistenciaTotal(sc,"Dame la asistencia");
    proyectoEntregado=validar.proyecto(sc,"Entrego su proyecto? si/no");

    nuevoAlumno.setName(name);
    nuevoAlumno.setCalificaciones(calificaciones);
    nuevoAlumno.setAsistencia(asistencia);
    nuevoAlumno.setEntregoProyecto(proyectoEntregado);

    guardar.puerta(nuevoAlumno);
    GradeService.imprimir(nuevoAlumno);






}

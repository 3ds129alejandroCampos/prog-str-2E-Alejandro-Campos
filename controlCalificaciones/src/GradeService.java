public class GradeService {
    public class alumnos {
        private String estado;
        private double promedioF;
        private double promedioA;
        private String name;
        private double[] calificaciones = new double[3];
        private double asistencia;
        private boolean entregoProyecto;

        public String getEstado() {
            return estado;
        }

        public void setEstado(String resultado) {
            this.estado= resultado;
        }

        public double getPromedioF() {
            return promedioF;
        }

        public void setPromedioF(double media) {
            this.promedioF= media;
        }

        public double getPromedioA() {
            return promedioA;
        }

        public void setPromedioA(double media) {
            this.promedioA= media;
        }

        public boolean getEntregoProyecto() {
            return entregoProyecto;
        }

        public void setEntregoProyecto(boolean entregoProyecto) {
            this.entregoProyecto = entregoProyecto;
        }



        public double getAsistencia() {
            return asistencia;
        }

        public void setAsistencia(double asistencia) {
            this.asistencia = asistencia;
        }

        public double[] getCalificaciones() {
            return calificaciones;
        }

        public void setCalificaciones(double[] calificaciones) {
            this.calificaciones = calificaciones;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
    public void puerta(alumnos student){
        calcularpromedio(student);
        calcularFinal(student);
    }
    private void calcularpromedio(alumnos student){
        double[] notas=student.getCalificaciones();
        double suma=0;
        double media=0;

        for (double n:notas){
            suma+=n;
        }
        media=suma/notas.length;
        student.setPromedioA(media);
    }
    private static void calcularFinal(alumnos student){
        double media;
        double asistencia=student.getAsistencia();
        boolean proyectoEntregado=student.getEntregoProyecto();
        if(asistencia>=80&&proyectoEntregado){
            media=(student.getPromedioA()*.7)+(asistencia*.3);
            if(media >=70){
                student.setPromedioF(media);
                student.setEstado("Aprobo todo");
            }
            else{
                student.setPromedioF(media);
                student.setEstado("Reprueba por promedio");
            }
        }
        else {
            if(asistencia < 80&&!proyectoEntregado){
                student.setEstado("Reprueba todo :c");
            }
            else {
                if (asistencia < 80) {
                    student.setEstado("Reprueba por asistencias(sin derecho a calificacion)");
                }
                if (!proyectoEntregado) {
                    student.setEstado("Reprobado por no entregar proyecto(sin derecho a calificacion)");
                }
            }
        }


    }
    public static void imprimir(alumnos student){
        double[] calificaciones= student.getCalificaciones();
        String proyecto=(student.getEntregoProyecto())? "Entregado": "Sin Entregar";

        System.out.println("---------------------");
        System.out.println("         BOLETA      ");
        System.out.println("Alumno: "+student.getName());
        for (int i=0;i<calificaciones.length;i++){
            System.out.println("parcial "+(i+1)+": "+calificaciones[i]);
        }
        System.out.println("promedio parciales"+student.getPromedioA());
        System.out.println("asistencia : "+student.getAsistencia());
        System.out.println("proyecto: "+proyecto);
        System.out.println("calificacion: "+student.getPromedioF()+" Estado: "+student.getEstado());
        System.out.println("---------------------");

    }
}

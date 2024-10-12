/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica;

/**
 *
 * @author roger
 */
public class PRACTICA {
    public static void main(String[] args) {
        // Crear instancias de Estudiante y Curso
        Estudiante estudiante1 = new Estudiante(1, "Juan", "Pérez", "2000-01-01", "matriculado");
        Estudiante estudiante2 = new Estudiante(2, "Ana", "García", "1999-06-15", "matriculado");

        Curso curso1 = new Curso(1, "Matemáticas", "Curso de álgebra", 3, "v1.0");

        // Instanciar GestorAcademico
        GestorAcademico gestor = new GestorAcademico();
        
        // Matricular estudiantes
        gestor.matricularEstudiante(estudiante1);
        gestor.matricularEstudiante(estudiante2);

        // Agregar curso
        gestor.agregarCurso(curso1);

        // Inscribir estudiante en el curso
        try {
            gestor.inscribirEstudianteCurso(estudiante1, curso1.getId());
            gestor.inscribirEstudianteCurso(estudiante2, curso1.getId());
            System.out.println("Estudiantes inscritos en el curso con éxito.");
        } catch (EstudianteYaInscritoException e) {
            System.out.println(e.getMessage());
        }

        // Desinscribir un estudiante
        try {
            gestor.desinscribirEstudianteCurso(estudiante1.getId(), curso1.getId());
            System.out.println("Estudiante desinscrito del curso con éxito.");
        } catch (EstudianteNoInscritoEnCursoException e) {
            System.out.println(e.getMessage());
        }
    }
}

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
import java.util.ArrayList;
import java.util.HashMap;

public class GestorAcademico implements ServiciosAcademicos {
    private ArrayList<Estudiante> estudiantes;
    private ArrayList<Curso> cursos;
    private HashMap<Integer, ArrayList<Estudiante>> inscripciones;

    public GestorAcademico() {
        estudiantes = new ArrayList<>();
        cursos = new ArrayList<>();
        inscripciones = new HashMap<>();
    }

    @Override
    public void matricularEstudiante(Estudiante estudiante) {
        if (!estudiantes.contains(estudiante)) {
            estudiantes.add(estudiante);
        }
    }

    @Override
    public void agregarCurso(Curso curso) {
        if (!cursos.contains(curso)) {
            cursos.add(curso);
        }
    }

    @Override
    public void inscribirEstudianteCurso(Estudiante estudiante, int idCurso) throws EstudianteYaInscritoException {
        if (!estudiantes.contains(estudiante)) {
            throw new EstudianteYaInscritoException("Estudiante ya está inscrito en este curso");
        }
        
        inscripciones.putIfAbsent(idCurso, new ArrayList<>());
        if (!inscripciones.get(idCurso).contains(estudiante)) {
            inscripciones.get(idCurso).add(estudiante);
        } else {
            throw new EstudianteYaInscritoException("El estudiante ya está inscrito en este curso");
        }
    }

    @Override
    public void desinscribirEstudianteCurso(int idEstudiante, int idCurso) throws EstudianteNoInscritoEnCursoException {
        ArrayList<Estudiante> estudiantesEnCurso = inscripciones.get(idCurso);
        
        if (estudiantesEnCurso == null || !estudiantesEnCurso.removeIf(e -> e.getId() == idEstudiante)) {
            throw new EstudianteNoInscritoEnCursoException("El estudiante no está inscrito en este curso");
        }
    }
}


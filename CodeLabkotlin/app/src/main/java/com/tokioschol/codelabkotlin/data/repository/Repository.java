package com.tokioschol.codelabkotlin.data.repository;

import com.tokioschol.codelabkotlin.domain.User;

import java.util.List;

public interface Repository {

    /**
     * Necesitamos hacer una clasificación nominal segun la edad del usuario.
     * Esta segmentación nos permitira dirigirnos al usuario o conocer sus edades
     * de forma segmentada.
     *
     * @param ages: user ages
     * @return nominal segmentation {"under7","younger","teen","adult","senior","are you alive"}
     */
    String classificationNameByAges(int ages);

    /**
     * Obtener una lista de la base de datos de los usuarios
     * @param segmentation type classification users
     * @return a list by segmentation selected
     */
    List<User> segmentationByType(String segmentation);


    /**
     * Ante la lista de usuarios => recuperada de una base de datos,
     * necesitamos conocer cuantos usuarios están en una segmentación concreta.
     * @param segmentation type classification users
     * @return number users find inside list by segmentation
     */
    int howManyUserBySegmentation(String segmentation);
}

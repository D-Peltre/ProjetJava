#------------------------------------------------------------
#        Script MySQL.
#------------------------------------------------------------


#------------------------------------------------------------
#        Database.
#------------------------------------------------------------
CREATE DATABASE `ProjetJavaBDD` ;

USE `ProjetJavaBDD` ;

#------------------------------------------------------------
# Table: Map
#------------------------------------------------------------

CREATE TABLE Map(
        Id_Map int Auto_increment  NOT NULL ,
        Map    Text ,
        PRIMARY KEY (Id_Map )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Procédure
#------------------------------------------------------------

DELIMITER |                                                      
CREATE PROCEDURE getMap (p_id_map INT)

BEGIN
    SELECT Map 
    FROM Race
    WHERE Id_Map = p_id_map ;                             
END |

DELIMITER ;
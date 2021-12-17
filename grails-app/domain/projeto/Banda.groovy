package projeto

class Banda {

    String nome
    String genero

    static hasMany = [shows: Shows]
    static belongsTo = [Shows]


    static constraints = {
    }
    static mapping = {
        shows joinTable:
        [name: "banda_shows",key:"id_banda",column: "id_shows"];
    }
}

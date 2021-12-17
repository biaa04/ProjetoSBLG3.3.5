package projeto

class Shows {

    Date data

    static hasMany = [bandas:Banda]
    //Local local
    static belongsTo = [local:Local]

    static constraints = {
        local nullable: true

    }
    static mapping = {
        table name : "shows"
        bandas joinTable:
        [name:"banda_shows", key:"id_shows",column:"id_banda"]
    }

}

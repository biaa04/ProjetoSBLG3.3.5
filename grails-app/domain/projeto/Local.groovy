package projeto

class Local {

    String endereco
    Integer capacidade

    static hasMany = [shows:Shows]

    static constraints = {

        shows nullable: true
    }
    static mapping = {
        shows column: "id_shows"

    }
}

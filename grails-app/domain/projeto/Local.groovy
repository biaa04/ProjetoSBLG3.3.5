package projeto

class Local {

    String endereco
    Integer capacidade

    static hasMany = [shows:Shows]

    static constraints = {
        endereco nullable: false, blank: false
        capacidade min: 0
        shows nullable: true
    }
    static mapping = {
        shows column: "id_shows"

    }
}

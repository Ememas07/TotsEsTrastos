var persona = {
    "name": "María", "edad": 23,
    "avisar": function () {
        alert("Hola soy " + this.name + " y mi edad es " + this.edad);
    }
};
persona.avisar();
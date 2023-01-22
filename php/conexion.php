<?php
include_once "miJWT.php";
    class conexion{
    private $laSuperConexion;
    private $elSuperJWT;

        function __construct(string $bd,string $ip = "localhost", string $user = "root", string $pass="") {
            $this->laSuperConexion = new mysqli($ip,$user,$pass,$bd);
            $this->elSuperJWT = new miJWT();

        }
        function close(){
            $this->laSuperConexion -> close();
        } 
        function opennew(string $bd,string $ip = "localhost", string $user = "root", string $pass=""){
            $this->laSuperConexion = new mysqli($ip,$user,$pass,$bd);
        }
        function buscarUsuario(string $user,string $password){
            $sql = "SELECT * FROM usuarios WHERE user='$user' and passwordd='$password'";
            $result = mysqli_query($this->laSuperConexion, $sql);
            $result = mysqli_fetch_all($result);
            if (count($result) !== 1)return[false];
            $token = $this->elSuperJWT->jwt($result[0][1],$result[0][2]);
            return [true,$result[0][1], $result[0][2],$token];//devuelve el user la pass y el token, podria devolver solo el token y true o flase
        }
        function registrarUsuario(){

        }

    }
?>
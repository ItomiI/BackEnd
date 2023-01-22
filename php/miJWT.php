<?php 

require_once "vendor/autoload.php";
use Firebase\JWT\JWT;

class miJWT
{
    public function jwt($user, $pass)
    {

        $time = time();

        $token = array(
            "iat" => $time,
            "emp" => $time + (24 * 60 * 60),
            "data" => ["user" => $user, "pass" => $pass]
        );
        $jwt = JWT::encode($token, "chupapija", "HS256");


        return $jwt;
    }
}

$solba = new miJWT();

  ?>
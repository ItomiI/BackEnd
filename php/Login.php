<?php 
header("Access-Control-Max-Age: 3600");
header("Access-Control-Allow-Methods: POST, PUT, DELETE, UPDATE");//probar sacar el put,delete update
header("Access-Control-Allow-Origin: * ");
header("Content-Type: application/json; charset=UTF-8");
header("Access-Control-Allow-Headers: Content-Type, Access-Control-Allow-Headers, Authorization, X-Requested-With");
#\
require_once "conexion.php";

$conexion = new conexion("usuarios");

$postdata = file_get_contents("php://input");
$request  = json_decode($postdata);

if (isset($postdata) && !empty($postdata)) {
  $busq = $conexion->buscarUsuario($request->user, $request->password);

  $object = (object) [
    'loged' => false,
    'user'=>'',
    'password'=>'',
    'token'=>''
  ];
  
  if($busq[0]){
    $object->loged = $busq[0];
    $object->user = $busq[1];
    $object->password = $busq[2];
    $object->token = $busq[3];
    echo json_encode($object);
  }else{
    $object->loged = $busq[0];
    $object->user = "";
    $object->password = "";
    $object->token = "";
    echo json_encode($object);
  }
  
}

$conexion -> close();
?>
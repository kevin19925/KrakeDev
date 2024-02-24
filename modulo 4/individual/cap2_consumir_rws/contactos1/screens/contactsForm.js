import { View, Text, StyleSheet, FlatList, Alert } from "react-native";
import { Button, ListItem, Input } from "@rneui/base";
import { useState, useEffect } from "react";
import { saveRest, updateRest, deleteRest } from "../rest_cliente/contact";
export const ContactForm = ({ navigation, route }) => {
  let Retrieved = route.params.objContact;
  let isNew = true;
  if (Retrieved != null) {
    isNew = false;
  }

  const [nombre, setNombre] = useState(isNew ? null : Retrieved.nombre);
  const [apellido, setApellido] = useState(isNew ? null : Retrieved.apellido);
  const [telefono, setTelefono] = useState(isNew ? null : Retrieved.celular);
  
  const crear = () => {
    saveRest({ nom: nombre, ape: apellido, tele: telefono }, mostrarAlert);
  };

  const actualizar = () => {
    updateRest(
      {
        id: Retrieved.id,
        nombre: nombre,
        apellido: apellido,
        celular: telefono,
      },
      mostrarAlert
    );
  };

  const mostrarAlert = (mensaje) => {
    Alert.alert("Confirmacion", mensaje, [
      {
        text: "ok",
        onPress: () => {
          navigation.goBack();
        },
      },
    ]);
  };

  const confir = () => {
    Alert.alert("Confirmacion ", "esta seguro que quiere eliminar", [
      {
        text: "SI",
        onPress: deletec,
      },
      { text: "NO" },
    ]);
  };

  const deletec = () => {
    deleteRest({ id: Retrieved.id }, mostrarAlert);
  };
  return (
    <View style={styles.container}>
      <Input
        value={nombre}
        placeholder="NOMBRE"
        onChangeText={(value) => {
          setNombre(value);
        }}
      ></Input>
      <Input
        value={apellido}
        placeholder="Apellido"
        onChangeText={(value) => {
          setApellido(value);
        }}
      ></Input>
      <Input
        value={telefono}
        placeholder="TELEFONO"
        onChangeText={(value) => {
          setTelefono(value);
        }}
      ></Input>

      <Button title="GUARDAR" onPress={isNew ? crear : actualizar}></Button>

      {isNew ? (
        <View></View>
      ) : (
        <Button title="ELIMINAR" onPress={confir}></Button>
      )}
    </View>
  );
};
const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: "#fff",
    alignItems: "center",
    justifyContent: "center",
  },
});

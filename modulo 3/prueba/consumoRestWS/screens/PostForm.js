import { View, StyleSheet, Alert } from "react-native";
import { Button, Input, Text } from "@rneui/base";
import { useState } from "react";
import { createPostService } from "../services/TestServices";

export const PostForm = ({ navigation }) => {
  const [subject, setSubject] = useState();
  const [message, setMessage] = useState();

  const createPost = () => {
    console.log("creando post " + subject + " " + message);
    createPostService(
      {
        codigo: subject,
        descripcion: message,
      },
      () => {
        Alert.alert("CONFIRMACION", "Se ha ingresado un nuevo POST");
      }
    );
  };
  return (
    <View style={styles.container}>
      <View style={styles.textContainer}>
        <Text h4="true">NUEVO MENSAJE</Text>
      </View>
      <View style={styles.formContainer}>
        <Input
          placeholder="codigo"
          value={subject}
          onChangeText={(value) => {
            setSubject(value);
          }}
        />
        <Input
          placeholder="descripcion"
          value={message}
          onChangeText={(value) => {
            setMessage(value);
          }}
        />

        <Button buttonStyle={styles.Btn} title="Guardar" onPress={createPost} />
        <Button
          buttonStyle={styles.Btn}
          title="ir a test"
          onPress={() => {
            navigation.navigate("TestWebServicesNav");
          }}
        />
      </View>
    </View>
  );
};
const styles = StyleSheet.create({
  container: {
    flex: 1,
    flexDirection: "column",
    backgroundColor: "#fff",
    justifyContent: "center",
  },
  textContainer: {
    flex: 1,
    flexDirection: "row",
    justifyContent: "center",
    alignItems: "center",
    marginVertical: 10,
  },
  formContainer: {
    flex: 4,
    flexDirection: "column",
    justifyContent: "center",
  },

  Btn: {
    backgroundColor: "green",
    borderRadius: 20,
    margin: 20,
  },
});

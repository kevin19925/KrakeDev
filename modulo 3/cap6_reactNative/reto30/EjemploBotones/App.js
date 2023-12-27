import { StatusBar } from "expo-status-bar";
import { Button, StyleSheet, Text, View, Alert } from "react-native";

export default function App() {
  const finalizar = () => {
    alert("SU SESION HA FINALIZADO");
  };

  return (
    <View style={styles.container}>
      <Text>Open up App.js to start working on your app!</Text>
      <StatusBar style="auto" />
      <Button title="FINALIZAR" onPress={finalizar} />
      <Button
        title=" INICIAR"
        onPress={() => {
          alert("SU SESION HA INICIADO");
        }}
      />
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: "#fff",
    alignItems: "center",
    justifyContent: "center",
  },
});

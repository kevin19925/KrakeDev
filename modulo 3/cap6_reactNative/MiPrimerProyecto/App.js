import { StatusBar } from "expo-status-bar";
import { Alert, Button, StyleSheet, Text, View } from "react-native";

export default function App() {
  const despedirse = () => {
    alert("chao");
  };

  return (
    <View style={styles.container}>
      <Text>hola como esta kevin quishpe </Text>
      <StatusBar style="auto" />
      <Button
        title="OK"
        // NO RECIBE Y NO RETORNA ND
        onPress={() => {
          Alert.alert("OK", "AYUDA");
        }}
      />

      <Button
        title="2"
        // NO RECIBE Y NO RETORNA ND
        onPress={despedirse}
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

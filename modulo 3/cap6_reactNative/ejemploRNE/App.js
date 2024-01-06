import { StatusBar } from "expo-status-bar";
import { StyleSheet, Text, View } from "react-native";
import { Button, Icon } from "@rneui/base";
import { Input } from "@rneui/themed";
import { useState } from "react";
export default function App() {
  const [name, setname] = useState();

  return (
    <View style={styles.container}>
      <Text>kevinXFZFD</Text>
      <Button
        title="aaaa"
        icon={{
          name: "twitter",
          type: "antdesign",
          size: 20,
          color: "white",
        }}
        onPress={() => {
          alert("su nombre es " + name);
        }}
      ></Button>
      <Input value={name} onChangeText={setname} placeholder="ingrese"></Input>
      <StatusBar style="auto" />
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

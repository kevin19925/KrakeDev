import { StyleSheet, Text, View, Button } from "react-native";

export const Home = ({ navigation }) => {
  return (
    <View style={styles.container}>
      <Text>Home</Text>
      <View style={styles.botones}>
        <Button
          title="contactos"
          onPress={() => {
            navigation.navigate("ContactNav");
          }}
        ></Button>
        <Button
          title="Productos"
          onPress={() => {
            navigation.navigate("ProductoNav");
          }}
        ></Button>
      </View>
    </View>
  );
};

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: "center",
   
  },
  botones: {
    flex: 1,
    flexDirection: "row",
    justifyContent: "space-around",
    alignItems: "center",
  },
});

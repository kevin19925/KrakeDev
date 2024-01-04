import { StyleSheet, Text, View, Button } from "react-native";
import { createNativeStackNavigator } from "@react-navigation/native-stack";

export const Contats = ({ navigation }) => {
  return (
    <View style={styles.container}>
      <Text>estoy en contacts</Text>
      <Button
        title="ir a home"
        onPress={() => {
          navigation.navigate("HomeNav");
        }}
      ></Button>
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

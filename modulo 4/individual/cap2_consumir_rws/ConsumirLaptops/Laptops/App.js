import { StatusBar } from "expo-status-bar";
import { StyleSheet, Text, View } from "react-native";

import { NavigationContainer } from "@react-navigation/native";
import { createNativeStackNavigator } from "@react-navigation/native-stack";
import { Lista } from "./screens/ScreenLaptop";
export default function App() {
  const Stack = createNativeStackNavigator();
  /*
 contenerdor 
  <NavigationContainer>
 // stract de pantallas   
<Stack.Navigator>

*/
  return (
    <NavigationContainer>
      <Stack.Navigator>
        <Stack.Screen name="LaptopsNav" component={Lista}></Stack.Screen>
      </Stack.Navigator>
    </NavigationContainer>
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

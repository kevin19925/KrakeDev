import {View,StyleSheet} from 'react-native'

export const ProductList=()=>{
    return <View style={styles.container}>
        <Text>LISTA DE PRODUCTOS</Text>
    </View>
}
const styles = StyleSheet.create({
    container: {
      flex: 1,
      backgroundColor: '#fff',
      alignItems: 'center',
      justifyContent: 'center',
    },
  });
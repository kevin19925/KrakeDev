import {View,StyleSheet,Alert} from 'react-native'
import {Button,Text} from '@rneui/base'
import {saveProduct,getAllProducts} from '../services/ProductServices'


export const ProductForm=()=>{
   const save=()=>{
    saveProduct();
   }
   const getAll=()=>{
      getAllProducts();
   }
    return <View style={styles.container}>
        <Text>FORMULARIO DE PRODUCTOS 4</Text>
        <Button
          title="Guardar"
          onPress={save}
        />
         <Button
          title="Consultar"
          onPress={getAll}
        />
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
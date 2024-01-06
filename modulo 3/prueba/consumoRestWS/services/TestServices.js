export const getAllPostsService = () => {
    fetch('https://jsonplaceholder.typicode.com/posts')
        .then((response) => response.json())
        .then((json) => console.log(json));
}

export const getByUserIdService = () => {
    fetch('https://jsonplaceholder.typicode.com/posts?userId=1')
        .then((response) => response.json())
        .then((json) => console.log(json));
}
 

export const createPostService = (post, fnExito) => {
    const config={
        method:'POST',
        body:JSON.stringify({
            codigo:post.codigo,
            descripcion:post.descripcion,
                
      }),
      headers: {
        'Content-type':'application/json',
      }
    };
    
        fetch('http://192.168.100.67:8080/inventarios-1.0.0/rest/tiposdocumento/crear',config)
    .then((response) => {
        return response.json()
    })
    .then((json) => { console.log(json); fnExito();});
}
 

export const updatePostService = () => {
    const config={
        method:'PUT',
        body:JSON.stringify({
                title: 'mensaje final',
                body: 'hasta la vista baby',
                userId: 1,
      }),
      headers: {
        'Content-type': 'application/json',
      }
    };
    
        fetch('https://jsonplaceholder.typicode.com/posts/1',config)
    .then((response) => {
        return response.json()
    })
    .then((json) => console.log(json));
}

export const getAllPostsService1 = () => {
    fetch('https://fakestoreapi.com/products')
        .then((response) => response.json())
        .then((json) => console.log(json));
}

export const createPostService1 = () => {
    const config={
        method:'POST',
        body:JSON.stringify({
                 title: 'test product',
                    price: 13.5,
                    description: 'lorem ipsum set',
                    image: 'https://i.pravatar.cc',
                    category: 'electronic'
      }),
      headers: {
        'Content-type': 'application/json',
      }
    };
    
        fetch('https://fakestoreapi.com/products',config)
    .then((response) => {
        return response.json()
    })
    .then((json) => console.log(json));
}
 

export const updatePostService1 = () => {
    const config={
        method:'PUT',
        body:JSON.stringify({
            title: 'test product',
            price: 13.5,
            description: 'loremnnnnnnn ipsum set',
            image: 'https://i.pravatar.cc',
            category: 'electronic'
      }),
      headers: {
        'Content-type': 'application/json',
      }
    };
    
        fetch('https://fakestoreapi.com/products/21',config)
    .then((response) => {
        return response.json()
    })
    .then((json) => console.log(json));
}

export const  getDocumentTypes = () => {
    fetch('http://192.168.100.67:8080/inventarios-1.0.0/rest/tiposdocumento/recuperar')
        .then((response) => response.json())
        .then((json) => console.log(json));
}
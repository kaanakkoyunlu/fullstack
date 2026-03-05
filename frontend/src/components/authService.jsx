import api from './api.jsx';

const authService = {
  
  async register(userData) {
    const response = await api.post('/api/reg/register', userData);
  
    const { token, username, roles } = response.data;
    sessionStorage.setItem("token", token);
    sessionStorage.setItem("username", username);
    sessionStorage.setItem("roles", JSON.stringify(roles));

    return response.data;
  },


  async login(credentials) {
    const response = await api.post('/api/reg/login', credentials);

    const {token, username, roles} = response.data;
    sessionStorage.setItem("token", token)
    sessionStorage.setItem("username", username)
    sessionStorage.setItem("roles", JSON.stringify(roles));
    
    return response.data;
  }

  // async logout() {
  //   return response.data;
  // }
}

export default authService;

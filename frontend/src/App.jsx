import './App.css'
import { BrowserRouter, Routes, Route } from "react-router-dom";
import ProtectedRoute from "./components/ProtectedRoute";
import Home from "./pages/Home";
import Login from "./pages/Login";
import Register from "./pages/Register";
import Welcome from "./pages/Welcome";
import Navbar from './components/NavBar';

function App() {
  return (
    <BrowserRouter>
      <Navbar />
      <Routes>

        <Route path="/" element={<Home />} />
        <Route path="/login" element={<Login />} />
        <Route path="/register" element={<Register />} />
        <Route
          path="/welcome"
          element={
            <ProtectedRoute>
              <Welcome />
            </ProtectedRoute>
          }
        />

        
      </Routes>
    </BrowserRouter>
  );
}
export default App;
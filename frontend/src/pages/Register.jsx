import { useState } from "react";
import { useNavigate } from "react-router-dom";
import authService from "../components/authService";

function Register() {
  const navigate = useNavigate();

  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");

  const handleRegister = async () => {
    try {
      await authService.register({username, password});

      navigate("/welcome");
    } catch (err) {
      alert("Registration failed");
    }
  };

  return (
    <div style={{ padding: "20px" }}>
      <h2>Register</h2>

      <input
        placeholder="Email"
        value={username}
        onChange={(e) => setUsername(e.target.value)}
      />
      <br /><br />

      <input
        type="password"
        placeholder="Password"
        value={password}
        onChange={(e) => setPassword(e.target.value)}
      />
      <br /><br />

      <button onClick={handleRegister}>Register</button>
    </div>
  );
}

export default Register;

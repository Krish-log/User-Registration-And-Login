import React, { useState, ChangeEvent, FormEvent } from "react";
import { Link } from "react-router-dom";
import axios from "axios";

const API_BASE_URL = "http://localhost:8080/api/users";

interface RegisterForm {
  username: string;
  password: string;
  email: string;
  firstName: string;
  lastName: string;
}

const Register: React.FC = () => {
  const [formData, setFormData] = useState<RegisterForm>({
    username: "",
    password: "",
    email: "",
    firstName: "",
    lastName: "",
  });
  const [message, setMessage] = useState<string>("");

  const handleChange = (e: ChangeEvent<HTMLInputElement>) => {
    setFormData({ ...formData, [e.target.name]: e.target.value });
  };

  const handleSubmit = async (e: FormEvent) => {
    e.preventDefault();
    setMessage("");
    try {
      const response = await axios.post<{ message: string }>(`${API_BASE_URL}/register`, formData, {
        headers: { "Content-Type": "application/json" },
      });
      setMessage(response.data.message);
    } catch (error: any) {
      setMessage(error.response?.data?.message || "An error occurred");
    }
  };

  return (
    <div>
      <h2>Register</h2>
      <form onSubmit={handleSubmit}>
        <input
          type="text"
          name="username"
          placeholder="Username"
          value={formData.username}
          onChange={handleChange}
          required
        />
        <input
          type="password"
          name="password"
          placeholder="Password"
          value={formData.password}
          onChange={handleChange}
          required
        />
        <input
          type="email"
          name="email"
          placeholder="Email"
          value={formData.email}
          onChange={handleChange}
          required
        />
        <input
          type="text"
          name="firstName"
          placeholder="First Name"
          value={formData.firstName}
          onChange={handleChange}
          required
        />
        <input
          type="text"
          name="lastName"
          placeholder="Last Name"
          value={formData.lastName}
          onChange={handleChange}
          required
        />
        <button type="submit">Register</button>
      </form>
      {message && <p>{message}</p>}
      <Link to="/login">Already have an account? Login</Link>
    </div>
  );
};

export default Register;

export const isAuthenticated = () => {
  return !!sessionStorage.getItem("token");
};

export const getRoles = () =>
  JSON.parse(sessionStorage.getItem("roles") || "[]");

export const hasRole = (role) =>
  getRoles().includes(role);

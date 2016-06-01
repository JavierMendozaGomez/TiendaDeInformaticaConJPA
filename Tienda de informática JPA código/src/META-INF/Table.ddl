CREATE TABLE tiendajpa.BODepartamento (id INTEGER NOT NULL AUTO_INCREMENT, activo BIT, nombre VARCHAR(255), telefono VARCHAR(255), PRIMARY KEY (id)) ENGINE = innodb;
CREATE TABLE tiendajpa.BOEmpleado (id INTEGER NOT NULL, activo BIT, dni VARCHAR(255), nombre VARCHAR(255), sueldo DOUBLE, telefono VARCHAR(255), BODEPARTAMENTO_ID INTEGER, PRIMARY KEY (id)) ENGINE = innodb;
CREATE TABLE tiendajpa.BOEmpleadoFijo (id INTEGER NOT NULL, aniosTrabajando INTEGER, PRIMARY KEY (id)) ENGINE = innodb;
CREATE TABLE tiendajpa.BOEmpleadoPracticas (id INTEGER NOT NULL, intencionQuedarse BIT, PRIMARY KEY (id)) ENGINE = innodb;
CREATE TABLE tiendajpa.BOTarea (id INTEGER NOT NULL, activo BIT, descripcion VARCHAR(255), nombre VARCHAR(255), PRIMARY KEY (id)) ENGINE = innodb;
ALTER TABLE tiendajpa.BOEmpleado ADD FOREIGN KEY (BODEPARTAMENTO_ID) REFERENCES tiendajpa.BODepartamento (id);
ALTER TABLE tiendajpa.BOEmpleadoFijo ADD FOREIGN KEY (id) REFERENCES tiendajpa.BOEmpleado (id);
ALTER TABLE tiendajpa.BOEmpleadoPracticas ADD FOREIGN KEY (id) REFERENCES tiendajpa.BOEmpleado (id);

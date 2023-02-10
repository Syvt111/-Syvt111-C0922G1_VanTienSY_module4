<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 1/6/2023
  Time: 8:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
  <title>Furama Resort Manager</title>
</head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
<body>

<div class="row vh-100 ">
  <div class="row bg-danger " style="height: 15%">
    <div class="col-md-2">
      <a class="navbar-brand d-flex justify-content-between" href="#"
         style="font-family: Broadway,serif">Furama</a>
    </div>
    <div class="col-md-8">

    </div>
    <div class="col-md-2 d-flex justify-content-center " style="margin-top: 35px; ">
      <a class="nav-link active d-flex justify-content-between" href="#">Van Tien Sy</a>
    </div>

  </div>
  <div class="header-link " style="height: 10%">
    <nav class="navbar navbar-expand-lg bg-body-tertiary">
      <div class="container-fluid">
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
          <ul class="navbar-nav me-auto mb-2 mb-lg-0">
            <li class="nav-item">
              <div class="col-md-2 ms-3">
                <a class="nav-link active" aria-current="page" href="home.jsp">Home</a>
              </div>
            </li>
            <li class="nav-item">
              <a class="nav-link dropdown-toggle" href="employee.jsp" role="button"
                 data-bs-toggle="dropdown"
                 aria-expanded="false">
                Employee
              </a>
              <ul class="dropdown-menu">
                <li><a class="dropdown-item" href="#">Action</a></li>
                <li><a class="dropdown-item" href="#">Another action</a></li>
                <li>
                  <hr class="dropdown-divider">
                </li>
                <li><a class="dropdown-item" href="#">Something else here</a></li>
              </ul>
            </li>
            <li class="nav-item">
              <a class="nav-link dropdown-toggle" href="customer.jsp" role="button"
                 data-bs-toggle="dropdown"
                 aria-expanded="false">
                Customer
              </a>
              <ul class="dropdown-menu">
                <li><a class="dropdown-item" href="#">Action</a></li>
                <li><a class="dropdown-item" href="#">Another action</a></li>
                <li>
                  <hr class="dropdown-divider">
                </li>
                <li><a class="dropdown-item" href="#">Something else here</a></li>
              </ul>
            </li>
            <li class="nav-item">
              <a class="nav-link dropdown-toggle" href="service.jsp" role="button"
                 data-bs-toggle="dropdown"
                 aria-expanded="false">
                Service
              </a>
              <ul class="dropdown-menu">
                <li><a class="dropdown-item" href="#">Action</a></li>
                <li><a class="dropdown-item" href="#">Another action</a></li>
                <li>
                  <hr class="dropdown-divider">
                </li>
                <li><a class="dropdown-item" href="#">Something else here</a></li>
              </ul>
            </li>
            <li class="nav-item">
              <a class="nav-link dropdown-toggle" href="contract.jsp" role="button"
                 data-bs-toggle="dropdown"
                 aria-expanded="false">
                Contract
              </a>
              <ul class="dropdown-menu">
                <li><a class="dropdown-item" href="#">Action</a></li>
                <li><a class="dropdown-item" href="#">Another action</a></li>
                <li>
                  <hr class="dropdown-divider">
                </li>
                <li><a class="dropdown-item" href="#">Something else here</a></li>
              </ul>
            </li>
          </ul>
          <form class="d-flex" role="search">
            <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
          </form>
        </div>
      </div>
    </nav>
  </div>
  <div class="row body vh-100 bg-light " style="height: 60%; padding: 2%">
    <div class="col-md-4 bg-light">
    </div>

    <h1 class="text-center my-3">LIST FACILITY </h1>
    <button type="button" class="btn btn-primary">ADD NEW FACILITY</button>
    <table class="table text-center">
      <thead>
      <tr>
        <th scope="col">ID</th>
        <th scope="col">Service Name</th>
        <th scope="col">Area</th>
        <th scope="col">Cost</th>
        <th scope="col">Max People</th>
        <th scope="col">Rent Type Id</th>
        <th scope="col">Service Type</th>
        <th scope="col">Standard</th>
        <th scope="col">Description</th>
        <th scope="col">Pool Area</th>
        <th scope="col">Number Of Floors</th>
        <th scope="col">Service Free</th>
      </tr>
      </thead>
      <tbody class="table-group-divider">
      <tr>
        <th scope="row">1</th>
        <td>Room</td>
        <td>120m2</td>
        <td>5000 USD</td>
        <td>5 people</td>
        <td>Month</td>
        <td>5</td>
        <td>Vip</td>
        <td>Full options</td>
        <td>20m2</td>
        <td>3</td>
        <td>Massage, Karaoke, BBQ</td>
        <td>
          <button type="button" class="btn btn-primary">EDIT</button>
        </td>
        <td>
          <!-- Button trigger modal -->
          <button type="button" class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#exampleModal">
            DELETE
          </button>
          <!-- Modal -->
          <div class="modal fade" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog">
              <div class="modal-content">
                <div class="modal-header">
                  <h1 class="modal-title fs-5">Modal title</h1>
                  <button type="button" class="btn-close" data-bs-dismiss="modal"
                          aria-label="Close"></button>
                </div>
                <div class="modal-body">
                  Are you sure ?
                </div>
                <div class="modal-footer">
                  <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Yes</button>
                  <button type="button" class="btn btn-primary">No</button>
                </div>
              </div>
            </div>
          </div>
        </td>
      </tr>
      <tr>
        <th scope="row">2</th>
        <td>House</td>
        <td>4500m2</td>
        <td>10000 USD</td>
        <td>10 people</td>
        <td>Month</td>
        <td>5</td>
        <td>Vip</td>
        <td>Full options</td>
        <td>15m2</td>
        <td>2</td>
        <td> Karaoke, BBQ</td>
        <td>
          <button type="button" class="btn btn-primary">EDIT</button>
        </td>
        <td>
          <!-- Button trigger modal -->
          <button type="button" class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#exampleModal">
            DELETE
          </button>
          <!-- Modal -->
          <div class="modal fade" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog">
              <div class="modal-content">
                <div class="modal-header">
                  <h1 class="modal-title fs-5">Modal title</h1>
                  <button type="button" class="btn-close" data-bs-dismiss="modal"
                          aria-label="Close"></button>
                </div>
                <div class="modal-body">
                  Are you sure ?
                </div>
                <div class="modal-footer">
                  <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Yes</button>
                  <button type="button" class="btn btn-primary">No</button>
                </div>
              </div>
            </div>
          </div>
        </td>
      </tr>
      <tr>
        <th scope="row">1</th>
        <td>Village</td>
        <td>1200m2</td>
        <td>50000 USD</td>
        <td>20 people</td>
        <td>Month</td>
        <td>2</td>
        <td>Vip</td>
        <td>Full options</td>
        <td>15m2</td>
        <td>2</td>
        <td>Massage, Karaoke, BBQ</td>
        <td>
          <button type="button" class="btn btn-primary">EDIT</button>
        </td>
        <td>
          <!-- Button trigger modal -->
          <button type="button" class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#exampleModal">
            DELETE
          </button>
          <!-- Modal -->
          <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel"
               aria-hidden="true">
            <div class="modal-dialog">
              <div class="modal-content">
                <div class="modal-header">
                  <h1 class="modal-title fs-5" id="exampleModalLabel">Modal title</h1>
                  <button type="button" class="btn-close" data-bs-dismiss="modal"
                          aria-label="Close"></button>
                </div>
                <div class="modal-body">
                  Are you sure ?
                </div>
                <div class="modal-footer">
                  <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Yes</button>
                  <button type="button" class="btn btn-primary">No</button>
                </div>
              </div>
            </div>
          </div>
        </td>
      </tr>
      </tbody>
    </table>
  </div>
  <div class="footer " style="height: 10%">
    <a class="col d-flex justify-content-center">Footer</a>
  </div>
</div>


</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
</html>

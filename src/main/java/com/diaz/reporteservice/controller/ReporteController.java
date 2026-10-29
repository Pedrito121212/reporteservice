package com.diaz.reporteservice.controller;

import com.diaz.reporteservice.entity.Reporte;
import com.diaz.reporteservice.service.ReporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reportes")
@CrossOrigin(origins = "*")
public class ReporteController {

    @Autowired
    private ReporteService reporteService;

    @PostMapping
    public ResponseEntity<Reporte> registrarReporte(@RequestBody Reporte reporte) {
        Reporte nuevo = reporteService.registrar(reporte);
        return new ResponseEntity<>(nuevo, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Reporte>> obtenerReportes(
            @RequestParam(defaultValue = "0") int offset,
            @RequestParam(defaultValue = "5") int limit
    ) {
        List<Reporte> lista = reporteService.obtenerPaginados(offset, limit);
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reporte> obtenerPorId(@PathVariable Integer id) {
        return reporteService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/ciudadano/{dni}")
    public ResponseEntity<List<Reporte>> obtenerPorCiudadano(@PathVariable String dni) {
        List<Reporte> lista = reporteService.obtenerPorCiudadano(dni);
        return ResponseEntity.ok(lista);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reporte> atenderReporte(@PathVariable Integer id) {
        return reporteService.atenderReporte(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}

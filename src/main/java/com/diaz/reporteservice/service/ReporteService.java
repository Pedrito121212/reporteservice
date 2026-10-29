package com.diaz.reporteservice.service;

import com.diaz.reporteservice.entity.Reporte;
import com.diaz.reporteservice.repository.ReporteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReporteService {

    @Autowired
    private ReporteRepository reporteRepository;

    public Reporte registrar(Reporte reporte) {
        if (reporte.getEstado() == null) {
            reporte.setEstado(1);
        }
        return reporteRepository.save(reporte);
    }

    public List<Reporte> obtenerPaginados(int offset, int limit) {
        int pageNumber = limit > 0 ? offset / limit : 0;
        int pageSize = limit > 0 ? limit : 5;
        return reporteRepository.findAll(PageRequest.of(pageNumber, pageSize)).getContent();
    }

    public Optional<Reporte> obtenerPorId(Integer id) {
        return reporteRepository.findById(id);
    }

    public List<Reporte> obtenerPorCiudadano(String dni) {
        return reporteRepository.findByDni(dni);
    }

    public Optional<Reporte> atenderReporte(Integer id) {
        return reporteRepository.findById(id).map(reporte -> {
            reporte.setEstado(0);
            return reporteRepository.save(reporte);
        });
    }
}

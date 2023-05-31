insert into ciclo values ('DAM', 'Desarrollo de Aplicaciones Multiplataforma');
insert into ciclo values ('PD', 'Protesis Dentales');
insert into ciclo values ('EI', 'Educación Infantil');
insert into ciclo values ('MC', 'Mediación Comunicativa');
insert into ciclo values ('IS', 'Integración Social');



insert into profesor values ('99999999Z','Juan Antonio', 'Pérez González');
insert into profesor values ('99999999Y','Manuel', 'Ramos García');
insert into profesor values ('99999999X','Ángel', 'Rodríguez Taverna');
insert into profesor values ('99999999V','Pablo', 'Llamas Ruíz');
insert into profesor values ('88888888Z','Andrés', 'Fernández Abascal');
insert into profesor values ('88888888Y','Ana', 'Pastor Ayuso');
insert into profesor values ('88888888X','Manuela Antonia', 'Bogdan Williams');
insert into profesor values ('77777777Z','Leylah', 'Fernández Fernández');
insert into profesor values ('77777777Y','Mariano', 'Rajoy Brey');
insert into profesor values ('77777777X','Iñaki', 'Carvajal Ramos');
insert into profesor values ('66666666Z','Beatriz', 'Habbad Maia');
insert into profesor values ('66666666Y','Martina', 'Andreeva Colignon');
insert into profesor values ('66666666X','Paula', 'Badosa Sánchez');
insert into profesor values ('66666666V','Juan José', 'Vukic Bellucci');
insert into profesor values ('55555555Z','Yannick', 'Hanfmann Sinner');
insert into profesor values ('55555555Y','Egor', 'Gerasimov Kirilov');
insert into profesor values ('55555555X','Christopher', 'Seradusic Rakitic');

insert into modulo values ('DAM','SIN','Sistemas Informáticos',1,6,'99999999Z');
insert into modulo values ('DAM','BD','Bases de Datos',1,6,'99999999Y');
insert into modulo values ('DAM','PRO','Programación',1,8,'99999999X');
insert into modulo values ('DAM','LM','Lenguajes de marcas y sistemas de gestión de información',1,4,'99999999X');
insert into modulo values ('DAM','ED','Entornos de Desarrollo',1,3,'99999999X');
insert into modulo values ('DAM','AD','Acesso a Datos',2,6,'99999999Y');
insert into modulo values ('DAM','DI','Desarrollo de Interfaces',2,6,'99999999Z');
insert into modulo values ('DAM','PM','Programación Multimedia y dispositivos móviles',2,6,'99999999Z');
insert into modulo values ('DAM','PSP','Programación de Servicios y Procesos',2,3,'99999999Y');
insert into modulo values ('DAM','SGE','Sistemas de Gestión Empresarial',2,6,'99999999Y');
insert into modulo values ('DAM','FOL','Formación y Orientación Laboral',1,3,'99999999V');
insert into modulo values ('DAM','EIE','Empresa e Iniciativa Emprendedora',2,3,'99999999V');
insert into modulo values ('DAM','PFG','Proyecto Fin de Grado',2,30,null);
insert into modulo values ('DAM','PE','Prácticas en la Empresa',2,380,null);

insert into modulo values ('PD','LPD','Laboratorio de Prótesis Dentales',1,2,'88888888Z');
insert into modulo values ('PD','DFP','Diseño Funcional de Prótesis',1,3,'88888888Z');
insert into modulo values ('PD','PC','Prótesis Completas',1,6,'88888888Y');
insert into modulo values ('PD','AOF','Aparatos de Ortodoncia y Férulas Oclusales',1,9,'88888888X');
insert into modulo values ('PD','REM','Restauraciones y Estructuras Metálicas en Protesis Fija',2,10,'88888888Z');
insert into modulo values ('PD','PPR','Prótesis Parciales Removibles metálicas, de resina y mixta',1,7,'88888888Y');
insert into modulo values ('PD','RRE','Restauraciones y Recubrimientos Estéticos',2,10,'88888888Z');
insert into modulo values ('PD','PSI','Prótesis Sobre Implantes',2,7,'88888888Y');
insert into modulo values ('PD','FOL','Formación y Orientación Laboral',1,3,'99999999V');
insert into modulo values ('PD','EIE','Empresa e Iniciativa Emprendedora',2,3,'99999999V');
insert into modulo values ('PD','PFG','Proyecto Fin de Grado',2,30,null);
insert into modulo values ('PD','PE','Prácticas en la Empresa',2,380,null);

insert into modulo values ('EI','DEI','Didáctica de la Educación Infantil',1,6,'77777777Z');
insert into modulo values ('EI','AUT','Autonomía Personal y Salud Infantil',1,5,'77777777Z');
insert into modulo values ('EI','EYC','Expresión y Comunicación',1,6,'77777777Z');
insert into modulo values ('EI','DCM','Desarrollo Cognitivo y de Motor',1,6,'77777777Y');
insert into modulo values ('EI','DS','Desarrollo Socioafectivo',1,4,'77777777Y');
insert into modulo values ('EI','HS','Habilidades Sociales',2,8,'77777777Y');
insert into modulo values ('EI','INT','Intervención con Familias y Atención a Menores en Riesgo Social',2,8,'77777777X');
insert into modulo values ('EI','PAU','Primeros Auxilios',2,2,'77777777X');
insert into modulo values ('EI','JIM','El Juego Infantil y su Metodología',2,9,'77777777X');
insert into modulo values ('EI','FOL','Formación y Orientación Laboral',1,3,'99999999V');
insert into modulo values ('EI','EIE','Empresa e Iniciativa Emprendedora',2,3,'99999999V');
insert into modulo values ('EI','PFG','Proyecto Fin de Grado',2,30,null);
insert into modulo values ('EI','PE','Prácticas en la Empresa',2,380,null);

insert into modulo values ('IS','CIS','Contexto de la Intevención Social',1,5,'66666666Z');
insert into modulo values ('IS','ISL','Inserción Sociolaboral',1,6,'66666666Z');
insert into modulo values ('IS','AUC','Atención a las Unidades de Convivencia',1,6,'66666666Z');
insert into modulo values ('IS','MC','Mediación Comunitaria',2,5,'66666666Y');
insert into modulo values ('IS','AIE','Apoyo a la Intervención Educativa',2,6,'66666666Y');
insert into modulo values ('IS','PAP','Promoción de la Autonomía Personal',1,7,'66666666Y');
insert into modulo values ('IS','SDC','Sistemas Aumentativos y Alternativos de Comunicación',2,6,'66666666X');
insert into modulo values ('IS','MIS','Metodología de la Intervención Social',1,3,'66666666X');
insert into modulo values ('IS','PAU','Primeros Auxilios',2,2,'66666666X');
insert into modulo values ('IS','HS','Habilidades Sociales',2,8,'66666666X');
insert into modulo values ('IS','FOL','Formación y Orientación Laboral',1,3,'66666666V');
insert into modulo values ('IS','EIE','Empresa e Iniciativa Emprendedora',2,3,'66666666V');
insert into modulo values ('IS','PFG','Proyecto Fin de Grado',2,30,null);
insert into modulo values ('IS','PE','Prácticas en la Empresa',2,380,null);

insert into modulo values ('MC','MIS',' Metodología de la integración social de las personas con dificultades de comunicación, lenguaje y habla',1,3,'55555555Z');
insert into modulo values ('MC','SCP','Sensibilizaciñón Social y Participación',1,4,'55555555Z');
insert into modulo values ('MC','ISP','Intervención Socioeducativa con Personas Sordociegas',1,5,'55555555Z');
insert into modulo values ('MC','CMC','Contexto de la mediación comunicativa con personas sordociegas',1,6,'55555555Z');
insert into modulo values ('MC','LS','Lengua de Signos',1,6,'55555555Y');
insert into modulo values ('MC','AAL','Ámbitos de Aplicación de la Lengua de Signos',2,6,'55555555Y');
insert into modulo values ('MC','IPD','Intervención con Personas con Dificultad de Comunicación',1,3,'55555555Y');
insert into modulo values ('MC','TIC','Técnicas de Intervención Comunicativa',2,5,'55555555Y');
insert into modulo values ('MC','SAC','Sistemas Aumentativos y Alternativos de Comunicación',2,6,'55555555X');
insert into modulo values ('MC','HS','Habilidades Sociales',2,8,'55555555X');
insert into modulo values ('MC','PAU','Primeros Auxilios',2,2,'55555555X');
insert into modulo values ('MC','FOL','Formación y Orientación Laboral',1,3,'66666666V');
insert into modulo values ('MC','EIE','Empresa e Iniciativa Emprendedora',2,3,'66666666V');
insert into modulo values ('MC','PFG','Proyecto Fin de Grado',2,30,null);
insert into modulo values ('MC','PE','Prácticas en la Empresa',2,380,null);


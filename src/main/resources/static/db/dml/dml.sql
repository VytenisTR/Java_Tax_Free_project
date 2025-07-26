INSERT INTO identity_document_types (code, name_en, name_lt) VALUES
('IDENTITY_CARD', 'Identity card', 'Asmens tapatybės kortelė'),
('PASSPORT', 'Passport', 'Pasas');

INSERT INTO measurement_units (code, name_short, name_long) VALUES
('ASV', '% vol', 'Alkoholio koncentracija, išreikšta tūrio procentais'),
('CEN', '100 p/st', 'Šimtas vienetų'),
('MIL', '1000 p/st', 'Tūkstantis vienetų'),
('KLT', '1000 l', 'Tūkstantis litrų'),
('GRM', 'g', 'Gramas'),
('HLT', 'hl', 'Hektolitras'),
('KGM', 'kg', 'Kilogramas'),
('LPA', 'l alc. 100%', 'Litras grynojo (100 proc.) alkoholio'),
('LTR', 'l', 'Litras'),
('NAR', 'p/st', 'Vienetų skaičius'),
('NPR', 'pa', 'Porų skaičius');

INSERT INTO residential_document_types (code, name_en, name_lt) VALUES
('CERTIFICATE', 'Certificate', 'Pažyma'),
('EXCERPT', 'Excerpt', 'Išrašas'),
('OTHER', 'Other', 'Kita');
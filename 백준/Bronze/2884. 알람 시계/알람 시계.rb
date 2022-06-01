h, m = gets.chomp.split
h = h.to_i
m = m.to_i
al = 45
if m-al < 0
    h -= 1
    if h < 0
        h = 23
    end
    m += 60
end
m -= al
puts "#{h} #{m}"